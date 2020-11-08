# contact-manager
Contact Manager with Birthday Wisher

## Local installation
1. Download Code
2. Execute `play run contact-manager`
3. Browse to http://localhost:9000/
4. There are two users created at startup 
   1. username: admin password: admin
   1. username: praneel password: praneel
   
## Configuration
1. Birthday Email sender job is configured to run at 23:00 to wish in advance. To change the timing, please configure the property
   `cron.noon` present in `application.conf` file
2. smtp properties aren't configured. By default it is mock. Mock birthday email can be seen in log. To add smtp settingd, modify 
`application.conf` with smtp settings and comment out `mail.smtp=mock`
 
