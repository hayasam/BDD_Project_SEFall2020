package najah.edu.app;

import org.mockito.Mockito;

public class MockEmailHolder {
	
	
	private EmailService emailService= Mockito.mock(EmailService.class);

	public MockEmailHolder(FinderApp finder) {
		finder.setEmailservice(emailService);
	}

	public EmailService getEmailService() {
		return emailService;
	}

	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}


	
	

}
