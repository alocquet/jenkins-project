pipeline {
  stages {
    stage('Build') {
  agent {
    kubernetes {
      label 'buildPod'
      containerTemplate {
        name 'maven'
        image 'java:8-jdk-alpine'
        ttyEnabled true
        command 'cat'
      }
      
    }
    
  }
      steps {
        sh './gradlew clean build'
      }
    }
  }
  post {
    success {
      archive 'build/libs/**/*.jar'
      junit 'build/test-results/**/*.xml'
      
    }
    
  }
}
