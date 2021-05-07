package com.jgs.navigationdrawer.ui.sobre;


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
public class SobreFragment extends Fragment {


    public SobreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_sobre, container, false);

        String descricao = "Assistência na correção de defeitos ou falhas nas redes ou " +
                "equipamentos; Desenvolvimento e instalação de softwares; Desenvolvimento de " +
                "sistemas para computadores; Desenvolvimento de websites na internet.";

        Element versao = new Element();
        versao.setTitle("Versão 1.0");

        return new AboutPage(getActivity())
                .setImage(R.drawable.logo)
                .setDescription(descricao)

                .addGroup("Redes Sociais")
                .addFacebook("","Facebook")
                .addInstagram("jose.gustavo312","Instagram")
                .addTwitter("JoseGustavo312","Twitter")
                .addYoutube("JGugu312","Youtube")
                .addGitHub("","GitHub")
                .addPlayStore("com.facebook.lite","Download App")

                .addItem(versao)

                .create();


    }

}
