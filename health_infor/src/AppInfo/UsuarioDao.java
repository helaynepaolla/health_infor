package AppInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {
	
	private Connection connection;
	public UsuarioDao () {
		try {
			this.connection = new conexao().getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		}
    public	void	adiciona(UsuarioBeans   usuariobeans)	{
    	
    	String	sql	= "insert into cadastro_de_usuario(Nome,Email,Senha)values(?,?,?)";
	
	try	{
	//	prepared	statement	para	inserção
	PreparedStatement	stmt = this.connection.prepareStatement(sql);
		
	//	seta	os	valores
	stmt.setString(1,usuariobeans.getNome());
	stmt.setString(2,usuariobeans.getEmail());
	stmt.setInt(3,usuariobeans.getSenha());
		
	//	executa	
	stmt.execute();
	stmt.close();
	}catch	(SQLException	e)	{
		throw	new	RuntimeException(e);
		}
	}
    
    public	List<UsuarioBeans>	getLista()	{
		try	{
			List<UsuarioBeans>	usuariobeans1	=	new	ArrayList<UsuarioBeans>();	
			PreparedStatement	stmt	=	this.connection.prepareStatement("select * from cadastro_de_usuario");
			ResultSet	rs	=	stmt.executeQuery();
		
			
    while(rs.next())	{
	//Criando o	objeto Contato
			
    	            UsuarioBeans usuariobeans0 =	new	UsuarioBeans();	
    	            usuariobeans0.setCod(rs.getInt("Cod"));
    	            usuariobeans0.setNome(rs.getString("Nome"));
    	            usuariobeans0.setEmail(rs.getString("Email"));
    	           // usuariobeans0.setSenha(rs.getInt("Senha"));
					
									
					//Adicionando o	objeto à lista
					usuariobeans1.add(usuariobeans0);
					}
	rs.close();
	stmt.close();
	return	usuariobeans1;
	}	catch	(SQLException	e)	{
		throw	new	RuntimeException(e);
	}
	}
	
	public	void pesquisa() throws SQLException{
		PreparedStatement	stmt	=	this.connection.prepareStatement("select	*	from cadastro_de_usuario");
		
		//	executa	um	select	
		ResultSet	rs	=	stmt.executeQuery();
		
		//	itera	no	ResultSet	
		while	(rs.next())	{	
			String	nome	=	rs.getString("nome");
			String	email	=	rs.getString("email");
					
			System.out.println("nome: " + nome+"   "+"Email: "+email);	
		}
		stmt.close();
		connection.close();
    }
	
	public	void altera(UsuarioBeans	usuariobeans) throws ParseException	{
	String	sql	=	"update	cadastro_de_usuario	set	Nome=?,	Email=?, Senha=?  where	Cod=?";
		try	{
			PreparedStatement	stmt	=	this.connection.prepareStatement(sql);
			
			stmt.setString(1,	usuariobeans.getNome());
			stmt.setString(2,	usuariobeans.getEmail());
			stmt.setInt(3,	usuariobeans.getSenha());
			
			stmt.setInt(4, usuariobeans.getCod());
			stmt.execute();
			stmt.close();
			}	catch	(SQLException	e)	{
				throw	new	RuntimeException(e);
				}	
		}
	
	public	void	remove(UsuarioBeans	usuariobeans)	{
		try	{
			PreparedStatement	stmt	=	(PreparedStatement) connection.prepareStatement("delete	from	5000000_sales_recordes	where	cod=?");
			stmt.setInt(1,	usuariobeans.getCod());
			stmt.execute();
			stmt.close();
			}	catch	(SQLException	e)	{	
				throw	new	RuntimeException(e);
				}
		} 
    
public void validacaologin(LoginBeans loginbeans)	{
	   
	try	{
    String	sql	= "SELECT * FROM cadastro_de_usuario where Email=? and Senha=? ";
	
    //prepared	statement	para	inserção
	PreparedStatement stmt = this.connection.prepareStatement(sql);
	stmt.setString(1, loginbeans.getEmail());
	stmt.setInt(2, loginbeans.getSenha());
	ResultSet rs = stmt.executeQuery();
	
	if (rs.next()) {

        String nome = rs.getString("Nome");
		System.out.print("login de "+nome+" foi logado com sucesso" ); 
	} else {
        
		String nomebens = loginbeans.getEmail();
		System.out.println(" não chegou a entra no banco ou a senha ta errada, ou o campo esta em branco, ou email ta errado nome veio da classe Loginbens o nome é  "+ nomebens);
    }
	
	//executa	
	//stmt.execute();
	stmt.close();
	
	}catch	(SQLException	e)	{
		System.out.println("Não chegou a entra no banco por que esta errado "+e);
		/*String nomebens = loginbeans.getNome();
		System.out.println(" o nome veio da classe Loginbens o nome é"+ nomebens);
		throw	new	RuntimeException(e);*/
	}
    
}

}
