pipeline {
    agent any

    tools {
        maven 'MAVEN' // Use the configured Maven installation
    }

    stages {
        stage('Run Maven Command') {
            steps {
                // Run the Maven command
                sh 'mvn clean install'
            }
        }
    }
    stage('Publish Report') {
    steps {
        publishHTML(target: [
            reportDir: 'report', // Directory where reports are located
            reportFiles: 'extent.html',  // Main report file
            reportName: 'Extent Report',  // Display name in Jenkins
            keepAll: true,                // Keep all reports
            alwaysLinkToLastBuild: true   // Link to the last build
        ])
    }
}
    
}
