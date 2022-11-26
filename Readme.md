[![build](https://github.com/barakb/silly-demo/actions/workflows/build.yml/badge.svg)](https://github.com/barakb/silly-demo/actions/workflows/build.yml)
[![Renovate enabled](https://img.shields.io/badge/renovate-enabled-brightgreen.svg)](https://renovatebot.com/)

#### 
open api http://localhost:9090/actuator/swagger-ui

#### k3d 
 * starting the cluster `k3d cluster create --config k3d-cluster.yml`
 * stopping the cluster `k3d cluster delete --config k3d-cluster.yml`

#### running silly demo pod quick and dirty way
 * create pod manually `kubectl run silly --image barakb/silly-demo:168e4bf`
 * exec in the pod `kubectl exec silly -- ps aux`
 * get shell into the pod `kubectl exec -it silly -- bash`
 * killing the java process `kubectl exec  silly -- pkill java`
 * deleting the pos `kubectl delete pod silly`

#### pod definition from a file
 * create pod from file `kubectl create -f pod/silly.yml`

#### more detailed view on pods
 * `kubectl get po -o wide`
 * `kubectl get po -o json`
 * `kubectl get po -o yaml`
 *  `kubectl describe pod silly`

#### getting logs
 * `kubectl logs silly -f`

#### 1 pod with 2 containers 
  * `kubectl create -f pod/silly2.yml`
  * get the log of the first container `kubectl logs -f silly2`
  * get the log of the second container `kubectl logs -f silly2 -c another-silly`
  * get the log of all containers of the pod `kubectl logs silly2 --all-containers` (can't follow)

#### Readyness prob
  * http://localhost:9090/actuator/health/readiness
  * not ready `kubectl create -f pod/silly-dead.yml` 
  * check `kubectl describe pod silly`
  * ready `kubectl create -f pod/silly-live.yml` 