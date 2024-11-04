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
    
    stage('Archive Reports') {
        archiveArtifacts artifacts: '**/report/*.html', allowEmptyArchive: true
    }
    
    stage('Publish Report') {
        publishHTML(target: [
            reportDir: 'report', // Adjust according to your report directory
            reportFiles: 'Suite_Results.html',  // Main report file
            reportName: 'Extent Report',  // Display name in Jenkins
            keepAll: true,                // Keep all reports
            alwaysLinkToLastBuild: true   // Link to the last build
        ])
    }
    
}
