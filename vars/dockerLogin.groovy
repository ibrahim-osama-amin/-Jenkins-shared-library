#!/usr/bin/env groovy

//import com.example.Docker

//def call() {
//    return new Docker(this).dockerLogin()
//}
def dockerlogin(){
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push nanajanashia/demo-app:jma-2.0'
}

