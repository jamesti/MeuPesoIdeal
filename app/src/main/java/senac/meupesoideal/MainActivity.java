package senac.meupesoideal;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                RadioButton masculino = findViewById(R.id.rbMasculino);

                double altura = Double.parseDouble(((EditText) findViewById(R.id.txtAltura)).getText().toString());
                double peso = Double.parseDouble(((EditText) findViewById(R.id.txtPeso)).getText().toString());
                double ideal_masculino = altura - 100 - ((altura - 150) / 4);
                double ideal_feminino = altura - 100 - ((altura - 150) / 2);
                double calculo_imc = peso / (altura / 100 * altura / 100);
                TextView ideal = findViewById(R.id.txtPesoIdeal);
                TextView imc = findViewById(R.id.txtIMC);

                if (masculino.isChecked()) {
                    ideal.setText("Peso Ideal: " + ideal_masculino + " Kg.");
                } else {
                    ideal.setText("Peso Ideal: " + ideal_feminino + " Kg.");
                }

                imc.setText("IMC: " + calculo_imc);

                String mensagem;

                    if (calculo_imc < 18.5) {
                        mensagem = "Abaixo do peso";
                    } else if (calculo_imc >= 18.5 && calculo_imc < 25) {
                        mensagem = "Peso Normal!";
                    } else if (calculo_imc >= 25 && calculo_imc < 30) {
                        mensagem = "Sobrepeso!";
                    } else if (calculo_imc >= 30 && calculo_imc < 35) {
                        mensagem = "Obesidade Grau 1!";
                    } else if (calculo_imc >= 35 && calculo_imc < 40) {
                        mensagem = "Obeso Grau 2!";
                    } else {
                    mensagem = "Muito Gordo!";
                }

                Snackbar.make(view, mensagem, Snackbar.LENGTH_LONG)
                        .setAction("Resultado", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
