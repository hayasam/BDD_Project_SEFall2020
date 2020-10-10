package najah.edu.app;

import org.mockito.Mockito;

public class MockEmailHolder {
	private WebEmailService emailService= Mockito.mock(WebEmailService.class);

	public MockEmailHolder(FinderApp finder) {
		finder.setEmailservice(emailService);
	}

	public WebEmailService getEmailService() {
		return emailService;
	}

	public void setEmailService(WebEmailService emailService) {
		this.emailService = emailService;
	}


	
}
