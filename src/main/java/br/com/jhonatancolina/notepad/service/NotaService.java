package br.com.jhonatancolina.notepad.service;

import br.com.jhonatancolina.notepad.model.Nota;
import br.com.jhonatancolina.notepad.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaService
{
    @Autowired
    NotaRepository notarepository;

    public void salvar(Nota nota)
    {
        Nota notas = notarepository.findByTitulo(nota.getTitulo());
        if(notas != null)
            nota.setId(notas.getId());

        notarepository.save(nota);
    }

    public List<Nota> buscarTodas()
    {
        return notarepository.findAll();
    }

    public Nota buscar(String titulo)
    {
        return notarepository.findByTitulo(titulo);
    }
}
