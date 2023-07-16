def call(creds,ip,warfile){
sshagent([creds]) {
  sh "scp target/${warfile} ec2-user@${ip}:/opt/tomcat/webapps"
  sh "ssh ec2-user@${ip} /opt/tomcat/bin/shutdown.sh"
  sh "ssh ec2-user@${ip} /opt/tomcat/bin/startup.sh"
}
}
