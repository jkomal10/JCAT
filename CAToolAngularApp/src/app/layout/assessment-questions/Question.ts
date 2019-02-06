import { QuestionOption } from "./Option";
import { MigrationRule } from "./MigrationRule";
import { CloudProviderRule } from "./CloudProviderRule";
export class AssessmentQuestions{

    questionId : number;
    questionText : string;
    questionDescription : string;
    questionType : string;
    questionDisplayOrder : number;
    numberOfOption : number;
    isActive : number;
    isDelete : number;
    assessmentTypeForMigration : string;
    assessmentTypeForCloudProvider : string;
    assessmentTypeForCloudable : string;
    createdBy : string;
    cteatedTime : Date;
    modifiedBy : string;
    modifiedTime : Date;
    answerValues : string;
    executionOrder:number;
    clientId : number;
    public questionOption : Array<QuestionOption> = [];
    public migrationRule : Array<MigrationRule> = [];
    public cloudProviderRules : Array<CloudProviderRule> = [];

}