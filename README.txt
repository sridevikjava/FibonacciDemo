The Fibonacci Demo is a simple application that displays the Fibonacci Series for the entered number.

The application can be built and run using the provided Maven pom.xml file under the project.

Pre-requisites to run and deploy the application:- 
1)	JDK6 is installed and ensure JAVA_HOME is set.
2)	Maven 3 is installed and MAVEN_HOME is set.

Steps to Build/Run the Application:-
1)	Open Command Prompt and navigate to path where FibonacciDemo is extracted.(make sure that pom.xml is available under the project)
2)	Key in mvn jetty:run (this command will build the project and starts the jetty server)
3)	Once the Jetty Server is started, In the web browser hit http://localhost:9090/FibonacciDemo (port 9090 can altered in pom.xml to desired port)
