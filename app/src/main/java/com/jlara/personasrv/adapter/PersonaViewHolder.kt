package com.jlara.personasrv.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.jlara.personasrv.Persona
import com.jlara.personasrv.R
import com.jlara.personasrv.databinding.ItemPersonaBinding

class PersonaViewHolder(private val binding: ItemPersonaBinding) : ViewHolder(binding.root) {

    fun render(persona: Persona, onClickListener: (Persona) -> Unit) {
        binding.tvNombre.text = persona.nombre
        binding.root.setOnClickListener {
            onClickListener(persona)
        }
        binding.tvDescripcion.text = persona.descripcion
        Glide.with(binding.ivPersona.context)
            .load(persona.imagen)
            .centerCrop()
            .placeholder(R.drawable.ic_persona_placeholder)
            .error(R.drawable.ic_persona_error)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding.ivPersona)
    }
}
