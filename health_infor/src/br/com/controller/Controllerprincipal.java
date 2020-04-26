package br.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import AppInfo.LoginBeans;
import AppInfo.UsuarioBeans;
import AppInfo.UsuarioDao;

@Controller
public class Controllerprincipal {
	
	@RequestMapping("ini")
	public	String	form()	{
		return	"tela-login";
	}
	
	@RequestMapping("telalogin")
	public String Validalogin(LoginBeans usuariobeans) {
		UsuarioDao	dao	=	new	UsuarioDao();
		dao.validacaologin(usuariobeans);
		return	"tela-inicial";
	}
	
	@RequestMapping("telacad")
	public	String	formi()	{
		return	"tela-cadastro-usuario";
	}
	
	@RequestMapping("telacadastrousuario")
	public	String	cadastrouser(UsuarioBeans usuariobeans)	{
		UsuarioDao	dao	= new UsuarioDao();
		dao.adiciona(usuariobeans);
		System.out.print("Entrou aqui no controlle principal");
		return	"tela-login";						
	}
	
	@RequestMapping("telalistausuario") 
	public	String	lista(Model model)	{
		UsuarioDao	dao	=	new	UsuarioDao();
		model.addAttribute("listacad",	dao.getLista());
		return	"tela-lista-usuario";
	}
}
