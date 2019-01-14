package miao.dto;

public class UserDTO {
    private String account;
    private String password;
    public String getAccount() {
        return account;
    }
    public void setAccount(String account) {
        this.account = account;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public UserDTO() {
        super();
    }
    public UserDTO(String account, String password) {
        System.out.println("已经进入UserDTO");
        this.account = account;
        this.password = password;
    }
}
