package com.example.joaopedrosantana.appcalculadora;

        import android.os.Bundle;
        import android.support.design.widget.FloatingActionButton;
        import android.support.design.widget.Snackbar;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.Toolbar;
        import android.view.View;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.widget.Button;
        import android.widget.TextView;

        import static com.example.joaopedrosantana.appcalculadora.R.id.buttonMenos;

public class MainActivity extends AppCompatActivity {
    TextView texto;
    float num1;
    float resultado;
    String operacao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texto = (TextView) findViewById(R.id.textView);
        texto.setText("");
    }
    public void clique(View view){
        if(view.getId() == R.id.buttonSoma || view.getId() == R.id.buttonMenos|| view.getId() == R.id.buttonporcento
                ||view.getId() == R.id.buttonX){
            Button botao = (Button) findViewById(view.getId());
            operNum((String) botao.getText());
        }
        else if(view.getId()==R.id.buttonIgual){
            MostraResultado();
        }
        else if(view.getId()==R.id.buttonC){
               C();
        }
        else{
            Button botao = (Button) findViewById(view.getId());
            String numero = (String)botao.getText();
            consNum(numero);
        }

    }
    public void consNum(String Num){
        String completa;
        String aux = (String)texto.getText();
        completa = aux + Num;
        texto.setText(completa);
    }

    public void operNum(String tipoOperacao){
        num1 = Float.parseFloat(texto.getText().toString());
        operacao = tipoOperacao;
        texto.setText("");
    }
    public void C(){
        texto.setText("");
        num1 = 0;
        resultado = 0;
        operacao = "";
    }

    public void MostraResultado(){
        resultado = 0;
        float num2 = 0;
        if(operacao.equals("+")) {
            num2 = Float.parseFloat(texto.getText().toString());
            resultado = num1 + num2;
            texto.setText(String.valueOf(resultado));
            num1 = resultado;
        }
        if(operacao.equals("-")) {
            num2 = Float.parseFloat(texto.getText().toString());
            resultado = num1 - num2;
            texto.setText(String.valueOf(resultado));
            num1 = resultado;
        }
        if(operacao.equals("*")) {
            num2 = Float.parseFloat(texto.getText().toString());
            resultado = num1 * num2;
            texto.setText(String.valueOf(resultado));
            num1 = resultado;
        }
        if(operacao.equals("%")) {
            num2 = Float.parseFloat(texto.getText().toString());
            resultado = num1 % num2;
            texto.setText(String.valueOf(resultado));
            num1 = resultado;
        }

    }
}
