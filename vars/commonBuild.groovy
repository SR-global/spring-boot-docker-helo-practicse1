def call() {
  stage ('checkout'){
    echo "hello Universe"
  }

  stage ('unit testing'){
    echo "unit testing"
  }
}
