pipeline {
    agent any

    tools {
        maven 'Maven3' // Use the configured Maven installation
    }

    stages {
        stage('Run Maven Command') {
            steps {
                // Run the Maven command
                sh 'mvn clean install'
            }
        }
    }
}
