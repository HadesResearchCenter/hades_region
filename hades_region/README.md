### HADES REGION

​	On August 17, 2020, the emergence of a mysterious anonymous email led to a blockchain network called "HADES".A careful study of the information found that HADES is not a simple blockchain network.He includes the blockchain ecology of "Decentralized Exchange Global Payment Public Chain System Guild System DiFi", and also established "[Blockchain Fourth-Generation Underlying Payment Technology]".
❶. BTC-led OMNI format ✔
The first-generation underlying payment technology can be distinguished by the address of the block, such as 19HN6wx8SnjRfH6DsbcH98VdWxZuLZmnf9. The general blockchain address starts with "19", which is the underlying technology of BTC.

❷ ETH-led ERC20 format ✔
The second-generation underlying payment technology can be distinguished by the address of the block, such as 0x4619576f5e85baab732ecadb1e1c199f5a5763be. Generally, the blockchain address starts with "0x" and is the underlying technology of ETH.

❸ TRX-led TRC20 format ✔
The third-generation underlying payment technology can be distinguished by the address of the block, such as TEoguCteP8Y9ZDZVtKXmczY29b1SvB9RH. Generally, the blockchain address starts with "TE", which is the underlying technology of TRX.

❹ HDS-led HRC20 format ✔
	The fourth-generation underlying payment technology can be distinguished by block addresses such as HDS19576f5e85baab732ecadb1e1c1f5a5763be. The emergence of each generation of underlying payment technology will bring about earth-shaking changes in the blockchain world.

​	HADES The emergence of decentralized networks will redefine the entire block world, establish a fourth-generation underlying payment ecosystem led by HDS, and build HDS into a universal payment currency for blockchain.

### Introduction

​	HADES is a blockchain ecosystem, which can also be said to be the fourth-generation underlying payment technology of blockchain.

​	HADES includes: "The fourth-generation underlying payment technology, decentralized exchange system, offline wallet system, global payment ecology, guild social system, and HDS public chain system."


Advantages of HADES:

1. Technical advantages: HADES opened the fourth-generation underlying payment technology of the blockchain, the first generation (BTC), the second generation (ETH), the third generation (TRX), and the fourth generation (HDS). All innovations will bring huge wealth.
2. Ecological advantages: In order to establish a global payment system, HADES has created its own complete ecosystem, relying on exchanges + global payment + public chain + settlement technology to create its own payment ecology; establishing a HDS core HADES is the only financial delivery medium to complete one-click payment with global payment/consumption APP through HDS, and complete the value exchange and cash withdrawal between HDS and global legal currency.

3. Consensus advantage: HADES is a decentralized blockchain ecology. In HADES, anyone can freely fight for/gain their rights without worrying about any risks and unfair behavior. HADES will give birth to the light of civilization.

4. Mechanism advantages: HADES uses a radar distribution mechanism to effectively decentralize users, establish more consensus systems, make the HADES world more balanced and free, and avoid the deprivation of rights of other users due to the concentration of rights. What HADES wants to establish is a A free, open and fair fourth era of blockchain

### Single node deployment

​	__This is very simple, just run like a normal SpringBoot project. The configuration of the node1 node used by the single node by default__

### Multi-node deployment

​	The project deploys 3 nodes by default and creates 3 configuration files ：application-{env}.yml , If you want to deploy more nodes, create more configuration files and it's OK.

​	It is very simple to use idea to deploy and test. Follow the method below to add multiple springBoot startup configurations.

![](install.png)

​	Then start 3 nodes separately. After startup, the nodes are automatically connected to a P2P network, and then you can use the postman tool to test. If you don't have postman installed, please install it yourself, or use the postman extension of the chrome browser like me.

### Web test API

|      API name       | Request method |           URL           |
| :-----------------: | :------------: | :---------------------: |
|   Generate wallet   |      POST      |      /account/new       |
|  View wallet list   |      GET       |      /account/list      |
|    Start mining     |      GET       |       /chain/mine       |
|  Send transaction   |      POST      | /chain/transactions/new |
| View the last block |      GET       |    /chain/block/view    |
|      Add node       |      POST      |     /chain/node/add     |
|      View node      |      GET       |    /chain/node/view     |

> Note: All POST requests use RequestBody to pass parameters, not the form-data form of the form. For example, the parameter form of sending transaction is as follows.
>
> ```json
> {
>     "name" : "value",
>     "name2" : "value2"
> }
> ```

### Simple test

​	First, start the node1-node3 3 nodes in turn. Since the initialized nodes will be automatically linked when they are started, each of them will be connected to a P2P network, so when the linked node is not started, a network exception will be thrown, don't worry about it, etc. After other nodes are started, they will be automatically connected.

> Create a wallet account   http://127.0.0.1:8081/account/new

__The response is as follows:__

```json
{
    "code": 200,
    "message": "New account created, please remember your Address and Private Key.",
    "item": {
        "address": "0xd7dd662e41c66ae31e493ca719a1d1e04a8174fe",
        "balance": 0,
        "privateKey": "aaaf41772d195fd61a236871a0e100589efaceee9f33c12491cb37e99b9a165d"
    }
}
```

> Mining, you must create a mining wallet before mining, the operation is the same as above.
>
> http://127.0.0.1:8081/chain/mine

__The response is as follows:__

```json
{
    "code": 200,
    "message": "Create a new block",
    "item": {
        "header": {
            "index": 8,
            "difficulty": 2.8269553036454149273332760011886696253239742350009903329945699220681916416e+73,
            "nonce": 9302,
            "timestamp": 1531739951847,
            "hash": "0002d041d584afb3609bfeb58a1eb25bef5540154f6b672522ce6e455c08c75b",
            "previousHash": "000c3738e3819bb52fc254e185eaae00dd39086a8bc2837cb4faf06d6edc51d6"
        },
        "body": {
            "transactions": [
                {
                    "from": null,
                    "sign": null,
                    "to": "0x69dc11cae775647d495b2c8930a17b31827b286b",
                    "publicKey": null,
                    "amount": 50,
                    "timestamp": 1531739951847,
                    "txHash": "0x472f84eb7488d4b72a5dc4c6b40b496dfa2b281c655fd2d4d1fefbd047b7fbda",
                    "status": "SUCCESS",
                    "errorMessage": null,
                    "data": "Miner Reward."
                }
            ]
        }
    }
}
```

> Send transaction   http://127.0.0.1:8081/chain/transactions/new

__The request method is POST, and the parameters are as follows:__

```json
{
	"from":"0x69dc11cae775647d495b2c8930a17b31827b286b",
	"to":"0x9f44d5aa11ba82b6e2cfe47ef529f8eabc6ebda5",
	"amount":5.5,
	"privateKey":"69c4caa1495e678208f1ee60f578a63ce5d0a6780541877454545a722175d760",
	"data":"hello world"
}
```

__The response is as follows:__

```json
{
    "code": 200,
    "message": "SUCCESS",
    "item": {
        "from": "0x69dc11cae775647d495b2c8930a17b31827b286b",
        "sign": "3045022100AE0606BACCDAFCBA8B84ED27B58B5F0239F243DEAFF46617E56864A6D8A677E702204DE4EBAC8213225D68D6395FD54602FCF24CD71D96E82F21DBEF77CADC43F70F",
        "to": "0x9f44d5aa11ba82b6e2cfe47ef529f8eabc6ebda5",
        "publicKey": "PZ8Tyr4Nx8MHsRAGMpZmZ6TWY63dXWSCz7FbyM3mvg3favYhhHXarHN6hXgYwKtvLAfXM5YgLDnZx1YPoo4G9pdiR5RQrhtBYriMCh5mGC3RC93HLFkBnAgi",
        "amount": 5.5,
        "timestamp": 1531739924777,
        "txHash": "0x74e5e59d69604b4081c81dae66f429febea9abb77ed6cd7f5b33e6da8ae667f9",
        "status": "APPENDING",
        "errorMessage": null,
        "data": "hello world"
    }
}
```

> View account list   http://127.0.0.1:8081/account/list

__The response is as follows:__

```json
{
    "code": 200,
    "message": "SUCCESS",
    "item": [
        {
            "address": "0x230ee512f454c4cb90e54b730d52a73e726b6db1",
            "balance": 0
        },
        {
            "address": "0x69dc11cae775647d495b2c8930a17b31827b286b",
            "balance": 269
        },
        {
            "address": "0x800c9be60dcec723525432338944dc6a7a8a9bc4",
            "balance": 0
        },
        {
            "address": "0x9f44d5aa11ba82b6e2cfe47ef529f8eabc6ebda5",
            "balance": 5.5
        },
        {
            "address": "0xd7dd662e41c66ae31e493ca719a1d1e04a8174fe",
            "balance": 0
        }
    ]
}
```

> View block   http://127.0.0.1:8081/chain/block/view

__The response is as follows:__

```json
{
    "code": 200,
    "message": "SUCCESS",
    "item": {
        "header": {
            "index": 9,
            "difficulty": 2.8269553036454149273332760011886696253239742350009903329945699220681916416e+73,
            "nonce": 18508,
            "timestamp": 1531740497326,
            "hash": "00059e0981bcd08ed4fbaf8973a738a2111ab5887c54e4b685579658cb4bb38c",
            "previousHash": "0002d041d584afb3609bfeb58a1eb25bef5540154f6b672522ce6e455c08c75b"
        },
        "body": {
            "transactions": [
                {
                    "from": null,
                    "sign": null,
                    "to": "0x69dc11cae775647d495b2c8930a17b31827b286b",
                    "publicKey": null,
                    "amount": 50,
                    "timestamp": 1531740497326,
                    "txHash": "0xd48edd85006ae5331fb934b0236944eb5f87761a3784582cd3dd03b793d17e5a",
                    "status": "SUCCESS",
                    "errorMessage": null,
                    "data": "Miner Reward."
                },
                {
                    "from": "0x69dc11cae775647d495b2c8930a17b31827b286b",
                    "sign": "30450220644FC1CAA4342AB7AFBEF200DA80E6870BBB9C5D3638CCE14635713B4E88BA80022100CA60B42FBDD6767E9605E005296499D682525D429BF0ACEECB450B826510534E",
                    "to": "0x9f44d5aa11ba82b6e2cfe47ef529f8eabc6ebda5",
                    "publicKey": "PZ8Tyr4Nx8MHsRAGMpZmZ6TWY63dXWSCz7FbyM3mvg3favYhhHXarHN6hXgYwKtvLAfXM5YgLDnZx1YPoo4G9pdiR5RQrhtBYriMCh5mGC3RC93HLFkBnAgi",
                    "amount": 5.5,
                    "timestamp": 1531740497291,
                    "txHash": "0x2a06176017345522882bbf6a6e5c4247ecdfc49fc705edab6e820f88af89add6",
                    "status": "APPENDING",
                    "errorMessage": null,
                    "data": "hello world"
                }
            ]
        }
    }
}
```
