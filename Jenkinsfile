pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git branch: 'main', url: 'https://github.com/SR-global/spring-boot-docker-helo-practicse1'

                // Run Maven on a Unix agent.
                sh "mvn -Dmaven.test.failure.ignore=true clean package"
            }
        }
        stage('docke img build') {
            steps {
                withCredentials([usernamePassword(credentialsId: '1', passwordVariable: 'pass', usernameVariable: 'user')]) {

    sh """
    docker build -t sujeetsr07/my-img3 .
    echo "$pass" | docker login -u $user --password-stdin
    
    docker push sujeetsr07/my-img3
    """
                    
                }
            }
        }
        stage('kubernetes work') {
            steps {
                withCredentials([file(credentialsId: 'kubernetes', variable: 'kube')]) {
    // some block
   sh """
   export KUBECONFIG=$kube
    kubectl apply -f deployment.yaml
    kubectl apply -f service.yaml
    """
    
}
            }
        }
    }
}
