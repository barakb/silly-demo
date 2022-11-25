[![build](https://github.com/barakb/silly-demo/actions/workflows/build.yml/badge.svg)](https://github.com/barakb/silly-demo/actions/workflows/build.yml)
[![Renovate enabled](https://img.shields.io/badge/renovate-enabled-brightgreen.svg)](https://renovatebot.com/)

#### k3d 
 * starting the cluster `k3d cluster create --config k3d-cluster.yml`
 * stopping the cluster `k3d cluster delete --config k3d-cluster.yml`

#### running silly demo pod quick and dirty way
 * kubectl run silly --image barakb/silly-demo:168e4bf
 * exec in the pod `kubectl exec silly -- ps aux`
 * get shell into the pod `kubectl exec -it silly -- bash`
 * killing the java process `kubectl exec  silly -- pkill java`
 * deleting the pos `kubectl delete pod silly`
