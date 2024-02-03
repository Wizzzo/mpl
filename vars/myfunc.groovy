def call (def name = "my name", def cfg = [:]){
    echo "${name}"
    echo "${cfg.toString()}"
}