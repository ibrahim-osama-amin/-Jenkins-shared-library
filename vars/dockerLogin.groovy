#!/usr/bin/env groovy

def dockerlogin(){
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push nanajanashia/demo-app:jma-2.0'
}

