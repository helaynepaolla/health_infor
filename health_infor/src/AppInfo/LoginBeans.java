package AppInfo;

public class LoginBeans {
	private String Nome;
	private	String	email;
	private	int Senha;
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSenha() {
		return Senha;
	}
	public void setSenha(String senha) {
		
        int numeroConvertido = Integer.parseInt(senha);
		Senha = numeroConvertido;
	}
}
