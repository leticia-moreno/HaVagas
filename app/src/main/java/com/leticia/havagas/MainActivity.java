package com.leticia.havagas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.leticia.havagas.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activity.getRoot());

        activity.checkCel.setOnClickListener((view) -> {
            if(activity.checkCel.isChecked()){
                activity.celular.setVisibility(View.GONE);
            }
            else{
                activity.celular.setVisibility(View.VISIBLE);
            }
        });

        activity.formacao.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 1 || i == 2){
                    activity.anoFormatura.setVisibility(View.VISIBLE);
                    activity.conclusao.setVisibility(View.GONE);
                    activity.instituicao.setVisibility(View.GONE);
                    activity.tituloMonografia.setVisibility(View.GONE);
                    activity.orientador.setVisibility(View.GONE);
                }
                else if(i == 3 || i == 4){
                    activity.conclusao.setVisibility(View.VISIBLE);
                    activity.instituicao.setVisibility(View.VISIBLE);
                    activity.tituloMonografia.setVisibility(View.GONE);
                    activity.orientador.setVisibility(View.GONE);
                    activity.anoFormatura.setVisibility(View.GONE);
                }
                else if(i == 5 || i == 6){
                    activity.conclusao.setVisibility(View.VISIBLE);
                    activity.instituicao.setVisibility(View.VISIBLE);
                    activity.tituloMonografia.setVisibility(View.VISIBLE);
                    activity.orientador.setVisibility(View.VISIBLE);
                    activity.anoFormatura.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        activity.botaoLimpar.setOnClickListener(
                (view) -> {
                    activity.nome.setText("");
                    activity.email.setText("");
                    activity.telefone.setText("");
                    activity.celular.setText("");
                    activity.checkEmail.setSelected(false);
                    activity.checkBox.clearCheck();
                    activity.checkCel.setSelected(false);
                    activity.anoFormatura.setText("");
                    activity.conclusao.setText("");
                    activity.instituicao.setText("");
                    activity.tituloMonografia.setText("");
                    activity.orientador.setText("");
                }
        );

        activity.botaoSalvar.setOnClickListener(
                (view) -> {
                    String nome = activity.nome.getText().toString();
                    String email = activity.email.getText().toString();
                    String telefone = activity.telefone.getText().toString();
                    String celular = activity.celular.getText().toString();
                    String anoFormatura = activity.anoFormatura.getText().toString();
                    String conclusao = activity.conclusao.getText().toString();
                    String instituicao = activity.instituicao.getText().toString();
                    String tituloMonografia = activity.tituloMonografia.getText().toString();
                    String orientador = activity.orientador.getText().toString();
                    String vagas = activity.vaga.getText().toString();
                    boolean celBool = activity.checkCel.isChecked();
                    boolean listaEmail = activity.checkEmail.isChecked();
                    boolean femBool = activity.femBtn.isChecked();
                    char genero = femBool ? 'F' : 'M';
                    String formacao = activity.formacao.getSelectedItem().toString();
                    int formacaoPos = activity.formacao.getSelectedItemPosition();
                    String result = "Nome: "+nome+",\nE-mail: "+email+",\nLista de E-mails: "+listaEmail+",\nTelefone: "+telefone+"\nCelular: "+celBool;
                    if(!celBool){
                        result = result + "\nTelefone Celular: "+celular;
                    }
                    result = result + "\nGênero: "+genero+"\nFormação: "+formacao;
                    if(formacaoPos == 1 || formacaoPos == 2){
                        result = result +"\nAno formatura: "+anoFormatura;
                    }
                    else if(formacaoPos == 3 || formacaoPos == 4){
                        result = result + "\nConclusão: "+conclusao+"\n Instituição: "+instituicao;
                    }
                    else if(formacaoPos == 5 || formacaoPos == 6){
                        result = result + "\nConclusão: "+conclusao+"\n Instituição: "+instituicao+"\nTítulo Monografia: "+tituloMonografia+"\nOrientador: "+orientador;
                    }
                    result = result + "\nVagas: "+vagas;
                    Toast.makeText(this, result, Toast.LENGTH_LONG).show();
                }
        );
    }
}