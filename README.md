# GraphQL
- In-memory
- Customize exceptions and response errors
## Schema
```
type Panel{
    id:ID!
    brandName:String
    panelType:PanelType
}

enum PanelType{
    IPS,
    VA,
    TN,
}


type Mutation{
    create(brandName:String,panelType:PanelType):Panel
    update(id:ID,brandName:String,panelType:PanelType):Panel
    deleteById(id:ID):Panel
}

type Query{
    findAll:[Panel]!
    findById(id:ID):Panel
}
```

## Queries And Mutations
### Find all items
```
query findAllItems {
  findAll {
    id
    brandName
    panelType
  }
}
```
### Find item by id
```
query findByItemId {
  findById(id: "$") {
    id
    brandName
    panelType
  }
}
```

### Create item
```
mutation createItem {
  create(brandName: "$", panelType:$) {
    id
    brandName
    panelType
  }
}
```

### Update item
```
mutation updateItem {
  update(id: "$", brandName: "$", panelType: $) {
    brandName
    id
    panelType
  }
}
```

### Delete item
```
mutation deleteItem {
  deleteById(id: "$") {
    id
    panelType
  }
}
```







