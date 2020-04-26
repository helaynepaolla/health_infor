package AppInfo;

public class ValidacaoLogin {

	public static void main(String[] args) {
//		pronto	para	gravar	
			LoginBeans	Loginbeans =	new	LoginBeans();
			Loginbeans.setEmail("helayne1@gmail.com");	
			Loginbeans.setSenha("1234567");	
			
		
		UsuarioDao	dao	=	new	UsuarioDao();
		dao.validacaologin(Loginbeans);

	}

}
