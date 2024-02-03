/**
 * Common checkout module
 */

def gitBranch = "master"
def gitUrl = CFG."git.url"
def gitRef = "+refs/heads/${gitBranch}:refs/remotes/origin/${gitBranch}"

checkout(
  changelog: false, 
  poll: false, 
  scm: [
      $class: 'GitSCM', branches: [[name: "master"]], 
      doGenerateSubmoduleConfigurations: false, 
      extensions: [
          [$class: 'CloneOption', honorRefspec: true, noTags: true, reference: '', shallow: true], 
          [$class: 'CleanBeforeCheckout'],
          ,[$class: 'WipeWorkspace']
      ],
      userRemoteConfigs: [
          [name: 'origin',  refspec: "${}", credentialsId: 'Gtihub-ssh-key', url: "${gitUrl}"]
      ]
  ]
)