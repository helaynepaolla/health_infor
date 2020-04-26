package AppInfo;

public class Cadastro {

	public static void main(String[] args) {
//		pronto	para	gravar	
			UsuarioBeans	login	=	new	UsuarioBeans();
			login.setNome("helayne");	
			login.setEmail("helayne@gmail.com");	
			login.setSenha(1234567);	
			
			//	grave	Nessa	conexão!!!	
			UsuarioDao	dao	=	new	UsuarioDao();
			//	método	elegante
			dao.adiciona(login);
			System.out.println("Gravado!");
			System.out.print("este dispositivo esta gravado");

	}

}
