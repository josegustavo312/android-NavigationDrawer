package com.jgs.navigationdrawer.ui.contato;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jgs.navigationdrawer.R;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContatoFragment extends Fragment {


    public ContatoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_contato, container, false);

        String descricao = "Assistência na correção de defeitos ou falhas nas redes ou " +
                "equipamentos; Desenvolvimento e instalação de softwares; Desenvolvimento de " +
                "sistemas para computadores; Desenvolvimento de websites na internet.";

        return new AboutPage(getActivity())
                .setImage(R.drawable.logo)
                .setDescription(descricao)

                .addGroup("Entre em contato")
                .addEmail("atendimento@atmconsultoria.com.br","Envie um email")
                .addWebsite("https://www.google.com.br/","Acesse nosso site")

                .create();
    }

}
