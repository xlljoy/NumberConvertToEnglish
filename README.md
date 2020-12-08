# NumberConvertToEnglish
Number convert to English

1. download the project to your cp/server by, 

	  `git clone https://github.com/xlljoy/NumberConvertToEnglish.git`

2. download Tomcat online https://tomcat.apache.org/download-90.cgi (there is an option `tar.gz (pgp, sha512)` for linux and Mac) and extract it,
	
    `tar -zxvf apache-tomcat-9.0.34.tar.gz`

   you will see a forlder generated: 
   `./apache-tomcat-9.0.34`

3. start Tomcat: 
	
    `./apache-tomcat-9.0.34/bin/startup.sh`

		 you may experience errors like: 

			Cannot find ./catalina.sh
			The file is absent or does not have execute permission
			This file is needed to run this program

		 If so, please try:
     
      `chmod a+x ./apache-tomcat-9.0.34/bin/catalina.sh`
     
      `./apache-tomcat-9.0.34/bin/startup.sh`

4. Copy `./NumberConvertToEnglish/NumberToEnglish.war` to Tomcat webadds folder,
	
    `cp ./NumberConvertToEnglish.war ~/apache-tomcat-9.0.34/webapps/`


5. Open the brower and input 'http://localhost:8080/o2o/admin/conversion';

6. Feel free to test the conversion result, please let me know if any error occurs, thank you.

7. Support range: int, positive, negative. Any illegal input would product a warning correspondingly.

8. shutdown Tomcat or restart it: 
  
     `./apache-tomcat-9.0.34/bin/shutdown.sh`
     
      `./apache-tomcat-9.0.34/bin/startup.sh`


UI snapshot: https://github.com/xlljoy/NumberConvertToEnglish/blob/main/1.png
