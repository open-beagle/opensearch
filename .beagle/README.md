# OpenSearch(ElasticSearch)

<https://github.com/opensearch-project/OpenSearch>

```bash
git remote add upstream git@github.com:opensearch-project/OpenSearch.git

git fetch upstream

git merge 1.3.14
```

## images

```bash
# amd64
docker pull opensearchproject/opensearch:1.3.14 && \
docker tag opensearchproject/opensearch:1.3.14 registry.cn-qingdao.aliyuncs.com/wod/opensearch:1.3.14-amd64 && \
docker push registry.cn-qingdao.aliyuncs.com/wod/opensearch:1.3.14-amd64

# arm64
docker pull --platform=linux/arm64 opensearchproject/opensearch:1.3.14 && \
docker tag opensearchproject/opensearch:1.3.14 registry.cn-qingdao.aliyuncs.com/wod/opensearch:1.3.14-arm64 && \
docker push registry.cn-qingdao.aliyuncs.com/wod/opensearch:1.3.14-arm64
```

## cache

```bash
# 构建缓存-->推送缓存至服务器
docker run --rm \
  -e PLUGIN_REBUILD=true \
  -e PLUGIN_ENDPOINT=$PLUGIN_ENDPOINT \
  -e PLUGIN_ACCESS_KEY=$PLUGIN_ACCESS_KEY \
  -e PLUGIN_SECRET_KEY=$PLUGIN_SECRET_KEY \
  -e DRONE_REPO_OWNER="open-beagle" \
  -e DRONE_REPO_NAME="opensearch" \
  -e PLUGIN_MOUNT="./.git" \
  -v $(pwd):$(pwd) \
  -w $(pwd) \
  registry.cn-qingdao.aliyuncs.com/wod/devops-s3-cache:1.0

# 读取缓存-->将缓存从服务器拉取到本地
docker run --rm \
  -e PLUGIN_RESTORE=true \
  -e PLUGIN_ENDPOINT=$PLUGIN_ENDPOINT \
  -e PLUGIN_ACCESS_KEY=$PLUGIN_ACCESS_KEY \
  -e PLUGIN_SECRET_KEY=$PLUGIN_SECRET_KEY \
  -e DRONE_REPO_OWNER="open-beagle" \
  -e DRONE_REPO_NAME="opensearch" \
  -v $(pwd):$(pwd) \
  -w $(pwd) \
  registry.cn-qingdao.aliyuncs.com/wod/devops-s3-cache:1.0
```
