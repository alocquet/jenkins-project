pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh './gradlew build'
      }
    }
  }
  post {
    success {
      archive 'build/libs/**/*.jar'
      junit 'build/reports/**/*.xml'
      
    }
    
  }
}