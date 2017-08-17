pipeline {
  agent {
    kubernetes {
      label 'build-jdk8'
      containerTemplate {
        name 'jdk8'
        image 'java:8-jdk-alpine'
        ttyEnabled true
        command '/bin/cat'
      }
    }
  }
  stages {
    stage('Build') {
      steps {
        sh './gradlew clean assemble'
      }
      post {
        success {
          archive 'build/libs/**/*.jar'
        }
      }
    }
    stage('Test') {
      steps {
        sh './gradlew check'
      }
      post {
        always {
          junit 'build/test-results/**/*.xml'
        }
      } 
    }
  }
}
