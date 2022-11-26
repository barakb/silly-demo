[![build](https://github.com/barakb/silly-demo/actions/workflows/build.yml/badge.svg)](https://github.com/barakb/silly-demo/actions/workflows/build.yml)
[![Renovate enabled](https://img.shields.io/badge/renovate-enabled-brightgreen.svg)](https://renovatebot.com/)

#### 
open api http://localhost:9090/actuator/swagger-ui

#### k3d 
 * starting the cluster `k3d cluster create --config k3d-cluster.yml`
 * stopping the cluster `k3d cluster delete --config k3d-cluster.yml`

### pods and containers
Pod group one or more containers with shared storage and network and specify how to run container

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

#### Readiness prob
  * http://localhost:9090/actuator/health/readiness
  * not ready `kubectl create -f pod/silly-dead.yml` 
  * check `kubectl describe pod silly`
  * ready `kubectl create -f pod/silly-live.yml` 

### replica set

Pods are not monitored by k8s if pod is gone k8s will do nothing.
Pods are not fault-tolerant
Pods are scaled with replica set

* create `kubectl create -f rs/silly.yml`
* get `kubectl get rs`
* describe `kubectl describe rs`
* show pods labels `kubectl get pods --show-labels`
* delete the replica set without the pods `kubectl delete -f rs/silly.yml --cascade=false`
* create with config on the controller `kubectl create -f rs/silly.yml --save-config`
* scale the replica set `kubectl apply -f rs/silly-scaled.yml`
* delete a pod `POD_NAME=$(kubectl get pods -o name | tail -1)` and afterward `kubectl delete $POD_NAME`
* remove property from a pod `POD_NAME=$(kubectl get pods -o name | tail -1) && kubectl label $POD_NAME service-`
* add the property back `kubectl label $POD_NAME service=silly`
