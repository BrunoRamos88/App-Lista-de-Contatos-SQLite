package com.everis.listadecontatos.feature.listacontatos.viewmodel

import com.everis.listadecontatos.application.ContatoApplication
import com.everis.listadecontatos.feature.listacontatos.model.ContatosVO
import com.everis.listadecontatos.feature.listacontatos.repository.ListaDeContatosRepository


class ListaDeContatosViewModel(
    var repository: ListaDeContatosRepository? = null
) {

    fun getListaDeContatos(
        busca: String,
        onSucesso: ((List<ContatosVO>) -> Unit),
        onError: ((Exception) -> Unit)
    ) {
        /*
        Thread(Runnable {
            Thread.sleep(1500)
            var listaFiltrada: List<ContatosVO> = mutableListOf()
            try {
                listaFiltrada = ContatoApplication.instance.helperDB?.buscarContatos(busca) ?: mutableListOf()
            } catch (ex: Exception) {
                ex.printStackTrace()
            }

            onSuceso(listaFiltrada)

        }).start()

         */

        Thread(Runnable {
            Thread.sleep(1500)
            repository?.requestListaDeContatos(
                busca,
                onSucesso = {lista ->
                    onSucesso(lista)
                }, onError = {ex ->
                    onError(ex)
                }
            )
        }).start()
    }
}