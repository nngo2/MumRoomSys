package edu.mum.roomsys.util;

import java.io.IOException;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

import edu.mum.roomsys.domain.Student;

@Aspect
@Component
public class EmailAdvice {
	@Value("${email.provider.key}")
	private String emailApiKey;

	@Around("execution(* edu.mum.roomsys..resetPassStudent(..))")
	public Object invoke(ProceedingJoinPoint call) throws Throwable {

		Student student = (Student)call.getArgs()[0];
		String orgPass = student.getPassword();

		Object retVal = call.proceed();
		
		sendMail(student.getEmail(), orgPass);
		
		return retVal;
	}

	private void sendMail(String toEmail, String message) {
		Email from = new Email("test@mum.edu");
		String subject = "Password changed";
		Email to = new Email(toEmail);
		Content content = new Content("text/plain", "Here is your new password: " + message);
		Mail mail = new Mail(from, subject, to, content);

		SendGrid sg = new SendGrid(emailApiKey);
		Request request = new Request();
		try {
			request.setMethod(Method.POST);
			request.setEndpoint("mail/send");
			request.setBody(mail.build());
			Response response = sg.api(request);
			System.out.println(response.getStatusCode());
			System.out.println(response.getBody());
			System.out.println(response.getHeaders());
		} catch (IOException ex) {
			//ex.printStackTrace();
			System.out.println(ex.getMessage());
		}
	}
}
