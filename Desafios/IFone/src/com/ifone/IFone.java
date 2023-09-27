package com.ifone;

public class IFone {
	private boolean ligado = false;
	private NavegadorInternet navegadorInternet = new NavegadorInternet();
	private AparelhoTelefonico aparelhoTelefonico = new AparelhoTelefonico();
	private ReprodutorMusical reprodutorMusical = new ReprodutorMusical();
	public void ligar() {
		ligado = true;
		System.out.println("Ifone ligado");
	}
	public void desligar() {
		System.out.println("Desligando...");
		ligado = false;
	}
	public void exibirPaginaNavegador(String url) {
		navegadorInternet.exibirPagina(url);
	}
	public void adicionarNovaPaginaNavegador(String url) {
		navegadorInternet.adicionarNovaPagina(url);
	}
	public void atualizarPaginaNavegador() {
		navegadorInternet.atualizarPagina();
	}
	public void telefoneChamar(long numero) {
		aparelhoTelefonico.chamar(numero);
	}
	public void telefoneAtender() {
		aparelhoTelefonico.atender();
	}
	public void telefoneIniciarCorreioDeVoz() {
		aparelhoTelefonico.iniciarCorreioDeVoz();
	}
	public void ipodTocar() {
		reprodutorMusical.tocar();
	}
	public void ipodPausar() {
		reprodutorMusical.pausar();
	}
	public void ipodSelecionarMusica(String musica) {
		reprodutorMusical.selecionarMusica(musica);
	}
}
