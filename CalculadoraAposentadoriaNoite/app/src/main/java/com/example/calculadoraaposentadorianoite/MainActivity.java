package com.example.calculadoraaposentadorianoite;

import static java.lang.String.valueOf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    private EditText Nome, Genero, Idade, Contribuicao;
    private TextView resultado;
    Scanner scanner = new Scanner(System.in);
    private int idadeAposentadoria;
    int anosFaltando;
    int ConAposentadoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Nome = findViewById(R.id.Nome);
        Genero = findViewById(R.id.Genero);
        Idade = findViewById(R.id.Idade);
        Contribuicao = findViewById(R.id.Contribuicao);


        resultado = findViewById(R.id.Resultado);

        Button GerarRelatorio = findViewById(R.id.BTrelatorio);
        GerarRelatorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular(v);
            }
        });
    }

    public void enviar (View view){
        Intent intent = new Intent(getApplicationContext(), Relatorio.class);
        intent.putExtra ("resultado", ((EditText)findViewById(R.id.Resultado)).getText().toString());
        startActivity(intent);
    }


    public void calcular(View view) {
        int idade = Integer.parseInt(Idade.getText().toString());
        int contribuicao = Integer.parseInt(Contribuicao.getText().toString());
        String nome = (Nome.getText().toString());

        String genero = valueOf(Genero.getText());

        if (genero.equals("M")) {
            idadeAposentadoria = 65;
            ConAposentadoria =20;
        } else if (genero.equals("F")) {
            idadeAposentadoria = 62;
            ConAposentadoria=15;
        } else {
            resultado.setText("Genero invalido");


        }

        if (idade >= idadeAposentadoria && contribuicao >= ConAposentadoria) {
            resultado.setText(String.valueOf(nome+" pode se aposentar pois tem "+idade+" anos de idade e "+contribuicao+" anos de contribuição"));
        } else {
            anosFaltando = ConAposentadoria - contribuicao;
            resultado.setText(String.valueOf(nome+ " não pode se aposentar pois tem "+idade+" e faltam " + anosFaltando + " anos para você se aposentar."));

       }


   }

    }





//public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        // Solicita os dados do usuário
//        System.out.print("Digite o seu gênero (M para masculino, F para feminino): ");
//        char genero = scanner.next().toUpperCase().charAt(0);
//
//        System.out.print("Digite a sua idade: ");
//        int idade = scanner.nextInt();
//
//        int idadeAposentadoria;
//
//        // Define a idade de aposentadoria com base no gênero
//        if (genero == 'M') {
//            idadeAposentadoria = 65;
//        } else if (genero == 'F') {
//            idadeAposentadoria = 60;
//        } else {
//            System.out.println("Gênero inválido.");
//            scanner.close();
//            return;
//        }

/*
parte anteriror
  public void calcular(View view) {
        int idade = Integer.parseInt(Idade.getText().toString());
        int contribuicao = Integer.parseInt(Contribuicao.getText().toString());
        resultado.setText(String.valueOf(20 - contribuicao));
        int Resultado = Integer.parseInt(resultado.getText().toString());
        String genero = String.valueOf(Genero.getText());

        if (genero.equals("M")) {
            idadeAposentadoria = 65;
        } else if (genero.equals("F")) {
            idadeAposentadoria = 60;
        } else {
            System.out.println("Gênero inválido.");
            scanner.close();

        }

    }
 */

//        // Verifica se a pessoa já pode se aposentar
//        if (idade >= idadeAposentadoria) {
//            System.out.println("Você já pode se aposentar.");
//        } else {
//            int anosFaltando = idadeAposentadoria - idade;
//            System.out.println("Faltam " + anosFaltando + " anos para você se aposentar.");
//        }
//
//        scanner.close();
//    }
//}

