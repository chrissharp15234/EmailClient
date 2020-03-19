package javatutorials.javamail;

public class JavaMail{
	public static void main(String[] args) throws Exception{
	
		JavaMailUtil.sendMail(args[0], args[1], args[2]);
	}
}