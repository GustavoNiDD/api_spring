package br.com.api_spring.DTO;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data
public class Personagem {

    int id;
    String login;
    String senha;
    String nomePersonagem;
    String classe;
    String especie;

    Date date = new Date();  
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");    
    String dtNascimento = formatter.format(date);

}
