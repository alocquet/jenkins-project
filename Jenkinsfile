pipeline {
  agent any
  stages {
    stage('Build') {
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