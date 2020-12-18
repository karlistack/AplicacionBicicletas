package com.example.aplicacionbicicletas

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        conectarconbd()

    }


    fun conectarconbd(){
        val listaBicicletas = ArrayList<Bicicletas>()
        val url="http://iesayala.ddns.net/mariadolores/Bicicletas.php"
        val cola = Volley.newRequestQueue(this)
        pantalla.layoutManager = LinearLayoutManager(this)
        val stringRequest = StringRequest(Request.Method.GET,url,{ response ->
            val jsonArray = JSONArray(response)

            for (i in 0 until jsonArray.length()) {
                val jsonObject = JSONObject(jsonArray.getString(i))
                val modelo = jsonObject.get("modelo").toString()
                val empresa = jsonObject.get("empresa").toString()
                val año = jsonObject.get("año").toString().toInt()
                val precio = jsonObject.get("precio").toString().toInt()
                val imagen = jsonObject.get("imagen").toString()

                val bici = Bicicletas(modelo,empresa,precio,año,imagen)
                listaBicicletas.add(bici)
            }

            if (listaBicicletas.size > 0) {
                pantalla.adapter = RecyclerAdapter(this, listaBicicletas)


            } else {
                Toast.makeText(applicationContext, listaBicicletas.size.toString(), Toast.LENGTH_LONG)
                        .show()

            }


        }, {
            Toast.makeText(applicationContext, "upps error de conexion", Toast.LENGTH_LONG).show()
        })

        cola.add(stringRequest)

    }

    }