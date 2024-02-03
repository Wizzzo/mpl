def func (name = "my name", cfg = [:]){
    echo "${name}"
    echo "${cfg.toString()}"
}