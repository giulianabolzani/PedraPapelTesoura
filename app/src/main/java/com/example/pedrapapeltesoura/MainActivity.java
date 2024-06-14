package com.example.pedrapapeltesoura;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void selecionarPedra( View view ){
        verificarGanhador("pedra");
    }

    public void selecionarPapel( View view ){
        verificarGanhador("papel");
    }

    public void selecionarTesoura( View view ){
        verificarGanhador("tesoura");
    }

    private String gerarEscolhaAleatoriaApp(){

        String[] opcoes = {"pedra", "papel", "tesoura"};
        int numeroAletorio = new Random().nextInt(3);

        ImageView imagemApp = findViewById(R.id.image_app);
        String escolhaApp = opcoes[numeroAletorio];
        switch (escolhaApp){
            case "pedra" :
                imagemApp.setImageResource(R.drawable.pedra);
                break;
            case "papel" :
                imagemApp.setImageResource(R.drawable.papel);
                break;
            case "tesoura" :
                imagemApp.setImageResource(R.drawable.tesoura);
                break;
        }

        return escolhaApp;
    }

    private void verificarGanhador( String escolhaUsuario ){

        String escolhaApp = gerarEscolhaAleatoriaApp();

        TextView textoResultado = findViewById(R.id.text_resultado);
        if(
            (escolhaApp == "pedra" && escolhaUsuario == "tesoura") ||
            (escolhaApp == "papel" && escolhaUsuario == "pedra") ||
            (escolhaApp == "tesoura" && escolhaUsuario == "papel")
        ){//App é ganhador
            textoResultado.setText("Você perdeu :(");
        }else if(
            (escolhaUsuario == "pedra" && escolhaApp == "tesoura") ||
            (escolhaUsuario == "papel" && escolhaApp == "pedra") ||
            (escolhaUsuario == "tesoura" && escolhaApp == "papel")
        ){//Usuario é ganhador
            textoResultado.setText("Você ganhou :D");
        }else{//Empatou
            textoResultado.setText("Empate! ;)");
        }

        System.out.println("Item clicado: " + escolhaUsuario);
    }


}