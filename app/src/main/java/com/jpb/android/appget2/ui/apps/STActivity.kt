package com.jpb.android.appget2.ui.apps

import com.jpb.android.appget2.R
import android.app.DownloadManager
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import java.io.BufferedReader
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL

class STActivity : AppCompatActivity() {
    var TextFileURL = "https://github.com/jpbandroid/AppGet-Resources/raw/main/USP/updated_date.txt"
    var TextFileURL2 = "https://github.com/jpbandroid/AppGet-Resources/raw/main/USP/version.txt"
    var TextFileURL3 = "https://github.com/jpbandroid/AppGet-Resources/raw/main/USP/description.txt"
    var TextFileURL4 = "https://github.com/jpbandroid/AppGet-Resources/raw/main/USP/changelog.txt"
    var textView10: TextView? = null
    var textView11: TextView? = null
    var textView14: TextView? = null
    var textView16: TextView? = null
    var toolbar: Toolbar? = null
    var installbut: Button? = null
    var url: URL? = null
    var TextHolder = ""
    var TextHolder2 = ""
    var TextHolder3 = ""
    var TextHolder4 = ""
    var TextHolder5 = ""
    var bufferReader: BufferedReader? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stactivity)
        textView10 = findViewById<TextView>(R.id.textView10)
        textView11 = findViewById<TextView>(R.id.textView11)
        textView14 = findViewById<TextView>(R.id.textView14)
        textView16 = findViewById<TextView>(R.id.textView16)
        toolbar = findViewById<Toolbar>(R.id.toolbar)
        installbut = findViewById(R.id.button2)
        installbut?.setOnClickListener(View.OnClickListener {
            val downloadmanager = getSystemService(DOWNLOAD_SERVICE) as DownloadManager
            val uri =
                Uri.parse("https://github.com/jpbandroid/AppGet-Resources/raw/main/USP/app-release.apk")
            val request = DownloadManager.Request(uri)
            request.setTitle("ScratchTappy")
            request.setDescription("Downloading")
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "ST.apk")
            downloadmanager.enqueue(request)
        })
        setSupportActionBar(toolbar)
        readUpdateDate()
        readVersion()
        readDescription()
        readChangelog()
    }

    private fun readUpdateDate() {
        object : Thread() {
            override fun run() {
                val path =
                    "https://github.com/jpbandroid/AppGet-Resources/raw/main/USP/updated_date.txt"
                var u: URL? = null
                try {
                    u = URL(path)
                    val c = u.openConnection() as HttpURLConnection
                    c.requestMethod = "GET"
                    c.connect()
                    val `in` = c.inputStream
                    val bo = ByteArrayOutputStream()
                    val buffer = ByteArray(1024)
                    `in`.read(buffer) // Read from Buffer.
                    bo.write(buffer) // Write Into Buffer.
                    runOnUiThread {
                        val text =
                            findViewById<View>(R.id.textView11) as TextView
                        text.text = "Updated: $bo"
                        try {
                            bo.close()
                        } catch (e: IOException) {
                            e.printStackTrace()
                        }
                    }
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }.start()
    }

    private fun readVersion() {
        object : Thread() {
            override fun run() {
                val path = "https://github.com/jpbandroid/AppGet-Resources/raw/main/USP/version.txt"
                var u: URL? = null
                try {
                    u = URL(path)
                    val c = u.openConnection() as HttpURLConnection
                    c.requestMethod = "GET"
                    c.connect()
                    val `in` = c.inputStream
                    val bo = ByteArrayOutputStream()
                    val buffer = ByteArray(1024)
                    `in`.read(buffer) // Read from Buffer.
                    bo.write(buffer) // Write Into Buffer.
                    runOnUiThread {
                        val text =
                            findViewById<View>(R.id.textView10) as TextView
                        text.text = "Version: $bo"
                        try {
                            bo.close()
                        } catch (e: IOException) {
                            e.printStackTrace()
                        }
                    }
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }.start()
    }

    private fun readDescription() {
        object : Thread() {
            override fun run() {
                val path =
                    "https://github.com/jpbandroid/AppGet-Resources/raw/main/USP/description.txt"
                var u: URL? = null
                try {
                    u = URL(path)
                    val c = u.openConnection() as HttpURLConnection
                    c.requestMethod = "GET"
                    c.connect()
                    val `in` = c.inputStream
                    val bo = ByteArrayOutputStream()
                    val buffer = ByteArray(1024)
                    `in`.read(buffer) // Read from Buffer.
                    bo.write(buffer) // Write Into Buffer.
                    runOnUiThread {
                        val text =
                            findViewById<View>(R.id.textView14) as TextView
                        text.text = bo.toString()
                        try {
                            bo.close()
                        } catch (e: IOException) {
                            e.printStackTrace()
                        }
                    }
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }.start()
    }

    private fun readChangelog() {
        object : Thread() {
            override fun run() {
                val path =
                    "https://github.com/jpbandroid/AppGet-Resources/raw/main/USP/changelog.txt"
                var u: URL? = null
                try {
                    u = URL(path)
                    val c = u.openConnection() as HttpURLConnection
                    c.requestMethod = "GET"
                    c.connect()
                    val `in` = c.inputStream
                    val bo = ByteArrayOutputStream()
                    val buffer = ByteArray(1024)
                    `in`.read(buffer) // Read from Buffer.
                    bo.write(buffer) // Write Into Buffer.
                    runOnUiThread {
                        val text =
                            findViewById<View>(R.id.textView16) as TextView
                        text.text = bo.toString()
                        try {
                            bo.close()
                        } catch (e: IOException) {
                            e.printStackTrace()
                        }
                    }
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }.start()
    }

    private fun readinfos() {
        object : Thread() {
            override fun run() {
                val path =
                    "https://github.com/jpbandroid/AppGet-Resources/raw/main/USP/changelog.txt"
                var u: URL? = null
                try {
                    u = URL(path)
                    val c = u.openConnection() as HttpURLConnection
                    c.requestMethod = "GET"
                    c.connect()
                    val `in` = c.inputStream
                    val bo = ByteArrayOutputStream()
                    val buffer = ByteArray(1024)
                    `in`.read(buffer) // Read from Buffer.
                    bo.write(buffer) // Write Into Buffer.
                    runOnUiThread {
                        val text =
                            findViewById<View>(R.id.textView13) as TextView
                        text.text = bo.toString()
                        try {
                            bo.close()
                        } catch (e: IOException) {
                            e.printStackTrace()
                        }
                    }
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }.start()
    }
}