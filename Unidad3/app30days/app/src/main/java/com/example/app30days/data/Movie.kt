package com.example.app30days.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.app30days.R

data class Movie(
    @StringRes val title: Int,
    @DrawableRes val imageResourceId: Int,
    @StringRes val description: Int,
    )

val movies = listOf(
    Movie(R.string.movie_title_1, R.drawable.casablanca, R.string.movie_description_1),
    Movie(R.string.movie_title_2, R.drawable.ciudadano_kane, R.string.movie_description_2),
    Movie(R.string.movie_title_3, R.drawable.lo_que_el_viento_se_llevo, R.string.movie_description_3),
    Movie(R.string.movie_title_4, R.drawable.psicosis, R.string.movie_description_4),
    Movie(R.string.movie_title_5, R.drawable.el_padrino, R.string.movie_description_5),
    Movie(R.string.movie_title_6, R.drawable.cantando_bajo_la_lluvia, R.string.movie_description_6),
    Movie(R.string.movie_title_7, R.drawable.vertigo, R.string.movie_description_7),
    Movie(R.string.movie_title_8, R.drawable.con_faldas_y_a_lo_loco, R.string.movie_description_8),
    Movie(R.string.movie_title_9, R.drawable.ben, R.string.movie_description_9),
    Movie(R.string.movie_title_10, R.drawable.el_halcon_maltes, R.string.movie_description_10),
    Movie(R.string.movie_title_11, R.drawable.rebelde_sin_causa, R.string.movie_description_11),
    Movie(R.string.movie_title_12, R.drawable.el_apartamento, R.string.movie_description_12),
    Movie(R.string.movie_title_13, R.drawable.la_dolce_vita, R.string.movie_description_13),
    Movie(R.string.movie_title_14, R.drawable.lawrence_de_arabia, R.string.movie_description_14),
    Movie(R.string.movie_title_15, R.drawable.nosferatu, R.string.movie_description_15),
    Movie(R.string.movie_title_16, R.drawable.un_tranvia_llamado_deseo, R.string.movie_description_16),
    Movie(R.string.movie_title_17, R.drawable.metropolis, R.string.movie_description_17),
    Movie(R.string.movie_title_18, R.drawable.la_ventana_indiscreta, R.string.movie_description_18),
    Movie(R.string.movie_title_19, R.drawable.cuentos_de_tokio, R.string.movie_description_19),
    Movie(R.string.movie_title_20, R.drawable.la_noche_del_cazador, R.string.movie_description_20),
    Movie(R.string.movie_title_21, R.drawable.eva_al_desnudo, R.string.movie_description_21),
    Movie(R.string.movie_title_22, R.drawable.el_septimo_sello, R.string.movie_description_22),
    Movie(R.string.movie_title_23, R.drawable.la_reina_africana, R.string.movie_description_23),
    Movie(R.string.movie_title_24, R.drawable.el_mago_de_oz, R.string.movie_description_24),
    Movie(R.string.movie_title_25, R.drawable.el_acorazado_potemkin, R.string.movie_description_25),
    Movie(R.string.movie_title_26, R.drawable.los_siete_samurais, R.string.movie_description_26),
    Movie(R.string.movie_title_27, R.drawable.el_ladron_de_bicicletas, R.string.movie_description_27),
    Movie(R.string.movie_title_28, R.drawable.gilda, R.string.movie_description_28),
    Movie(R.string.movie_title_29, R.drawable.el_gabinete_del_dr_caligari, R.string.movie_description_29),
    Movie(R.string.movie_title_30, R.drawable.tiempos_modernos, R.string.movie_description_30)
)