package com.jlara.personasrv

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.jlara.personasrv.adapter.PersonaAdapter
import com.jlara.personasrv.databinding.ActivityMainBinding
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var adapter: PersonaAdapter
    private var listaPersonas: List<Persona> = emptyList()

    private fun onItemSelected(persona: Persona) {
        Toast.makeText(this, "Has pulsado sobre ${persona.nombre}", Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        listaPersonas = PersonaProvider.cargarPersonas()
        layoutManager = LinearLayoutManager(this)
        binding.rvPersonas.layoutManager = layoutManager
        binding.rvPersonas.setHasFixedSize(true)
        binding.rvPersonas.itemAnimator = DefaultItemAnimator()
        adapter = PersonaAdapter { persona -> onItemSelected(persona) }
        binding.rvPersonas.adapter = adapter
        adapter.submitList(listaPersonas)
    }

}
