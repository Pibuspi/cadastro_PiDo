package model;

public class Cliente {
	
	private int id;
    private String nome;
    private String data_nasc;
    private String cpf;
    private String email;
    private String senha;
    
    public Cliente() {
    }
    
    public Cliente(int id, String nome, String data_nasc, String cpf, String email, String senha) {
 this.id = id;
 this.nome = nome;
 this.data_nasc = data_nasc;
 this.cpf = cpf;
 this.email = email;
 this.senha = senha;
}
    public int getId() {
        return id;
      }

      public void setId(int id) {
        this.id = id;
      }

      public String getNome() {
        return nome;
      }

      public void setNome(String nome) {
        this.nome = nome;
      }

      public String getData_nasc() {
        return data_nasc;
      }

      public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
      }

      public String getCpf() {
        return cpf;
      }

      public void setCpf(String cpf) {
        this.cpf = cpf;
      }

      public String getEmail() {
        return email;
      }

      public void setEmail(String email) {
        this.email = email;
      }

      public String getSenha() {
        return senha;
      }

      public void setSenha(String senha) {
        this.senha = senha;
      }
    

}
