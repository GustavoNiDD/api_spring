package br.com.api_spring.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.api_spring.DTO.Personagem;

@Controller
public class PersonagemController {

    private List<Personagem> personagens = new ArrayList<>();

    @PostMapping("/cadastrarPersonagem")
    public String cadastrarCliente(Model model, Personagem personagem) {
        personagens.add(personagem);
        return cadastroPersonagens(model);
    }

    @GetMapping("/cadastroPersonagem")
    public String cadastroPersonagens(Model model) {
        model.addAttribute("personagem", personagens);
        return "paginaCadastroPersonagem";
    }

    @GetMapping("visualizarPersonagens")
    public String visualizarPersonagens(Model model) {
        model.addAttribute("personagem", personagens);
        return "paginaPersonagens";
    }

    @GetMapping("/deletarPersonagem/{id}")
    public String deletarPersonagem(Model model, Personagem personagem, @PathVariable int id) {
        int index = 0;

        for (Personagem personagem2 : personagens) {
            if (personagem2.getId() == id) {
                break;
            } else {
                index++;
            }
        }
        personagens.remove(index);
        return cadastroPersonagens(model);
    }

    @PostMapping("/editarPersonagem/{id}")
    public String editarPersonagem(Model model, Personagem personagem, @PathVariable int id) {
        int index = 0;
        for (Personagem personagem2 : personagens) {
            if (personagem2.getId() == id) {
                personagem2.setLogin(personagem.getLogin());
                personagem2.setSenha(personagem.getSenha());
                personagem2.setNomePersonagem(personagem.getNomePersonagem());
                personagem2.setClasse(personagem.getClasse());
                personagem2.setEspecie(personagem.getEspecie());
                personagem2.setDate(personagem.getDate());
                break;
            } else {
                index++;
            }
        }
        return cadastroPersonagens(model);
    }

}
